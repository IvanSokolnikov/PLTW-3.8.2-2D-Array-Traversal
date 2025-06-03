public class Tile {
    public String value;
    public boolean hidden = true;
    public boolean matched = false;

    public Tile(String v) {
        value = v;
    }

    public boolean isShowing() {
        return !hidden;
    }

    public boolean isMatched() {
        return matched;
    }
}
