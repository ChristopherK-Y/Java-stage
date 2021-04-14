public class InsertSQL {
    public static void main(String[] args) {
        String[] names = {"红楼梦", "西游记", "三国演义", "水浒传"};
        int[] totals = {10, 3, 7, 9};

        String sqlTemplate = "INSERT INTO `java21_2021_04_13`.`books` (`bid`, `bookname`, `total`, `count`) VALUES ('%d', '%s', '%d', '%d');\n";

        for (int i = 0; i < 4; i++) {
            String name = names[i];
            int total = totals[i];

            String sql = String.format(sqlTemplate, i + 1, name, total, total);
            System.out.printf(sql);
        }
    }
}
