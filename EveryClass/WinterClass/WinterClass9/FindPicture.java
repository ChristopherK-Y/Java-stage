public class FindPicture {
    public static void imageFilenames(String[] array) {
        for (String temp : array) {
            if (temp.endsWith(".png") || temp.endsWith(".jpg")) {
                System.out.println(temp.substring(0, temp.length() - 4));
            }
        }
    }

    public static void main(String[] args) {
        String[] array = {"板书.png", "记事本.exe", "游戏1.exe", "图片1.jpg", "图片2.png"};
        imageFilenames(array);
    }

}
