//这份代码是先从左边开始扫描
public class quick_sort {
    public void quick_sort(int[] array, int left, int right) {
        int i = 0;
        int j = 0;
        int select = 0;
        int temp = 0;

        if (left >= right) {
            return;
        }

        i = left;      //or left+1
        j = right;
        select = array[left];

        while (true) {
            while (array[i] <= select) {
                i++;
                if (i == right) break;
            }
            while (array[j] >= select) {
                j--;
                if (j == left) break;
            }

            if (i >= j) {
                break;
            }

            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        temp = array[j];
        array[j] = array[left];
        array[left] = temp;

        quick_sort(array, left, j - 1);
        quick_sort(array, j + 1, right);
    }
}