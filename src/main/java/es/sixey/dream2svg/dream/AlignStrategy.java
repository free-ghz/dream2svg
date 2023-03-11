package es.sixey.dream2svg.dream;

public enum AlignStrategy {
        AUTO,
        CENTER,
        NONE,
        BLOCK;

        public static AlignStrategy forValue(String string) {
                switch (string) {
                        case "auto":
                                return AUTO;
                        case "center":
                                return CENTER;
                        case "none":
                        case "no":
                                return NONE;
                        case "block":
                                return BLOCK;
                        default:
                                System.err.println("I don't understand AlignStrategy " + string);
                                return null;
                }
        }
}