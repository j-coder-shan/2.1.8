public class selectionSort {
    public void sort(productList list){
        for (int i = list.size - 1; i >= 0 ; i--) {
            int maxIndex = getMaxIndex(i);
            Product temp = productList.list[maxIndex];
            productList.list[maxIndex] = productList.list[i];
            productList.list[i] = temp;
        }
    }

    private int getMaxIndex(int i) {
        int index = i;
        for (int j = index; j > 0 ; j--) {
            if (productList.list[index].salesAmount < productList.list[j].salesAmount){
                index = j;
            }
        }
        return index;
    }
}
