# .dream to .svg "projector"

This is a tiny software to render text files as SVG. It's based on the [Dreamwiki](https://github.com/free-ghz/dreamwiki) code, and as such uses its file format when reading text. This brings some interesting control, which may or may not compensate for its shortcomings.

It is expressly meant to produce files to be used with the [Axidraw plotter](https://axidraw.com/) through the [Inkscape](https://inkscape.org/) addon, but the output is general purpose SVG.

## Features

- Define custom "alphabets", ie the glyphs to use for each letter, expressed as collections of lines
  - Multiple alphabets can be used for the same file, the glyphs from each will be put in a separate group in the svg. This can be used to separate for example punctuation, for separate processing later.
  - Case _insensitive_.
- Have control over line wrapping/alignment by way of commands in the .dream files; this means you can do block for some paragraphs and center others
- Optional "wavyness", IE periodic offset/size change of outputted characters, to produce ripple-like patterns
- Output SVG is sorted to reduce passive travel distance by the plotter, this actualy makes a huge difference to plotting time

### .dream command structure

Some control over the output can be had through _commands_ in the input file. A command goes on it's own line, and follow the pattern of `^ command name ^ argument1 argument2 ... ^`. Lines starting with a `^` that do not follow this pattern are treated as comments.

As an example, to center text, use `^ align ^ center ^`. To disable "curtains" (generated decorations on the side of the page), use `^ curtains ^ none ^`. For the complete list of commands, see the [Dreamwiki primer](https://dreamwiki.sixey.es/!primer), although be aware that not all of them are implemented here (`tags` makes no sense in this context, for example).

# Quirks

Lot's of quirks at this point! For one, i didn't build this into an executable, i just run it from inside the IDE all the time; as such all "configuration" is made by editing the source code in the appropriate (hopefully) place;

...and as _such_, the code is mostly a bunch of quick hacks stapled together. It's probably in need of a complete rewrite to look good, but i'm not going to do that.

Eventually i'm meaning to at least store the alphabet definitions in files and read those, instead of the current `List.of()`-approach.

The SVG sorter doesn't really "understand" SVG. It's just a bunch of string splits and joins. It likes whatever output is created by the SVG library, it does NOT like Inkscape output. I'm to lazy to figure it out currently.

# Examples

Since these are meant to be plotted, for output i'll show the final result.

## Siren's vine

### Input

```
^ align ^ center ^
333333333333333333333
3   siren's vine.   3
333333333333333333333

^ align ^ auto ^
for thousands of years known only to
"witches", by which i mean various
cunning SWAMP dwellers 33333333333333333
^ align ^ block ^
333333333333333333333333 amphibian 3
3 LIZARDS, humanoid frogs, GIRLS, 3
3 actual WITCHES, and lots of insects 3
```

### Output

![sirensvine](https://raw.githubusercontent.com/free-ghz/dream2svg/trunk/ex_witch.jpg "sirensvine")

## Wave

### Input

```
7899999 9 999
8999873289   
987421EA1W11
753DRE1111111
51DR122222211
1DR1122222222
1R11222222232
R111185447233
E111743233623
A118421112373
M117421SI1243
W118421 X1137
I1195449EY127
1K11989EYE237
1IS1111YE1233
211IXEYE11273
6211111112634
4642222237443
4446655644444
6544444444456
7766544445666
6677766666641
13566666541E
  LA1111K   9
9         998
```

### Output

![wave](https://raw.githubusercontent.com/free-ghz/dream2svg/trunk/ex_wave.jpg "wave")

## Diamond pattern

### Input

```
x4x4x4x4x4x4x
4x4x4x4x4x4x4
x4x4x4x4x4x4x
4x4x4x4x4x4x4
x4x4x4x4x4x4x
4x4x4x4x4x4x4
x4x4x4x4x4x4x
4x4x4x4x4x4x4
x4x4x4x4x4x4x
4x4x4x4x4x4x4
x4x4x4x4x4x4x
4x4x4x4x4x4x4
x4x4x4x4x4x4x
4x4x4x4x4x4x4
x4x4x4x4x4x4x
4x4x4x4x4x4x4
x4x4x4x4x4x4x
4x4x4x4x4x4x4
x4x4x4x4x4x4x
4x4x4x4x4x4x4
x4x4x4x4x4x4x
4x4x4x4x4x4x4
x4x4x4x4x4x4x
4x4x4x4x4x4x4
x4x4x4x4x4x4x
```

### Output


![x4pattern](https://raw.githubusercontent.com/free-ghz/dream2svg/trunk/ex_4x4x.jpg "x4pattern")