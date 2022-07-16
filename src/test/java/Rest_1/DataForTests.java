package Rest_1;

import org.testng.annotations.DataProvider;

public class DataForTests {
    @DataProvider(name="Data for post")
    public Object[][] dataForPost(){
        //Object[row][col]
//        Object[][] data=new Object[2][3];
//        data[0][0]="Tom";
//        data[0][1]="Jordan";
//        data[0][2]=2;
//
//        data[1][0]="Kelli";
//        data[1][1]="Compas";
//        data[1][2]=1;
//        return data;
        //2. not hard coding
        return new Object[][]{
                {"Ehet","Molla",1},
                {"Ehmet","Molla",2 }
        };
    }
    @DataProvider(name ="Delete data")
    public Object[] dataForDelete(){
        return new Object[] {
                4,5,6
        };
    }


}
