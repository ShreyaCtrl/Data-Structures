#include <stdio.h>
int a[20];
int partition(int p, int q) {
    int pivot = a[p];
    int i = p, j = q;
    do {
        while (pivot <= a[i]) {
            i++;
        }
        while(pivot >= a[j]) {
            j--;
        }
        if (i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    } while (i <= j);
    a[p] = a[j];
    a[j] = pivot;
    return j;
}
void quicksort(int p, int q) {
    int j;
    if (p < q) {
        j = partition(p, q + 1);
        quicksort(p, j - 1);
        quicksort(j + 1, q);
    }
}
void main() {
    int n, i, j;
    printf("Enter the size of array : ");
    scanf("%d", &n);
    printf("Enter the elements of array : ");
    for (i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }
    quicksort(0, n - 1);
    printf("The sorted array is : ");
    for (i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
}