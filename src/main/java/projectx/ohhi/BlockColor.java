package projectx.ohhi;

public enum BlockColor {
    RED("r"),
    BLUE("b"),
    EMPTY(".");

    private final String color;

    BlockColor(String color) {
        this.color = color;
    }

    public static BlockColor forColor(String color) {
        for (BlockColor blockColor : values()) {
            if (blockColor.getColor().equals(color)) {
                return blockColor;
            }
        }
        throw new IllegalArgumentException("No BlockColor for symbol " + color);
    }

    public String getColor() {
        return color;
    }

    public static BlockColor getInverseColor(BlockColor blockColor) {
        if (blockColor == BlockColor.BLUE) {
            return BlockColor.RED;
        }
        if (blockColor == BlockColor.RED) {
            return BlockColor.BLUE;
        }
        return BlockColor.EMPTY;
    }
}
