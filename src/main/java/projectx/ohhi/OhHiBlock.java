package projectx.ohhi;

public class OhHiBlock {

    BlockColor blockColor = BlockColor.EMPTY;

    public OhHiBlock(String color) {
        blockColor = BlockColor.forColor(color);
    }

    public BlockColor getBlockColor() {
        return blockColor;
    }

    public boolean isEmpty() {
        return blockColor == BlockColor.EMPTY;
    }

    @Override
    public String toString() {
        return getBlockColor().getColor();
    }

    public void setBlockColor(BlockColor blockColor) {
        this.blockColor = blockColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OhHiBlock ohHiBlock = (OhHiBlock) o;

        if (blockColor != ohHiBlock.blockColor) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return blockColor != null ? blockColor.hashCode() : 0;
    }
}
