package Task1;

import java.util.Arrays;

public class CustString {
    char[] MyString;

    public CustString(char[] MyString) {
        try {
            this.MyString = MyString;
        }
        catch (Exception e) {

        }
        finally {
            this.MyString = MyString;
        }
    }

    @Override
    public String toString() {
        return new String(MyString);
    }
}
