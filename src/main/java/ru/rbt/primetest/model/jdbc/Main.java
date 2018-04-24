package ru.rbt.primetest.model.jdbc;

/**
 * Created by BritikovMI on 25.07.2017.
 */
public class Main {
    public static void main(String args[]) {
        String[][] context;
        context = getDBInf("SHOW_TABLE");
    }

    public static String[][] getDBInf(String query){
        String s1;
//        String query = args[0];
        QueryManager queryManager = new QueryManager();
        String s = queryManager.runQuery(query).toString();

        s1 = s.replace("[", "");
        s = s1.replace("]", "");

        String[] splits = s.split(",");

        for (int i = 0; i < splits.length; i++) {
            System.out.println(splits[i]);
        }

        String[] fstSplits = new String[(splits.length) / 3];
        String[] secSplits = new String[(splits.length) / 3];
        String[] thplits = new String[(splits.length) / 3];
        for (int i = 0; i < (splits.length) / 3; i++) {
            fstSplits[i] = splits[i * 3];
        }

        secSplits[0] = splits[1];
        secSplits[1] = splits[4];
        secSplits[2] = splits[7];
        secSplits[3] = splits[10];
        secSplits[4] = splits[13];

        thplits[0] = splits[2];
        thplits[1] = splits[5];
        thplits[2] = splits[8];
        thplits[3] = splits[11];
        thplits[4] = splits[14];
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        for (int i = 0; i < (splits.length) / 3; i++) {
            System.out.println(fstSplits[i]);
        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        for (int i = 0; i < splits.length / 3; i++) {
            System.out.println(secSplits[i]);
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        for (int i = 0; i < splits.length / 3; i++) {
            System.out.println(thplits[i]);
        }

        String[][] test = new String[][]{fstSplits, secSplits, thplits};

       /* System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        for (int i = 0; i <3; i++)
            for(int j = 0; j < fstSplits.length; j++)
                System.out.print(test[i][j]);*/



        return test;
    }

}