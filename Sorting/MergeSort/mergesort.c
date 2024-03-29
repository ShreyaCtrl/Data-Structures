#include <stdio.h>
int arr[10], b[10];

void merge(int low, int mid, int high) {
	int l = low, i = low, m = mid+1;
	
	while ((l <= m) && (m <= high)) {
		if (arr[l] <= arr[m]) {
			b[i] = arr[l];
			l++;
		}
		else {
			b[i] = arr[m];
			m++;
		}
		i++;
	}
	
	if (l < m) {
		for (i = l; i <= m; i++) {
			b[i] = arr[l];
			l++;
		}
	}
	else {
		for (i = m; i <= high; i++) {
			b[i] = arr[m];
			m++;
		}
	}
	
	for (i = low; i <= high; i++) {
		arr[i] = b[i];
	}
}

void mergeSort (int low, int high) {
	if (low < high) {
		int mid = (low+high)/2;
		
		mergeSort(low, mid);
		mergeSort(mid+1, high);
		
		merge(low, mid, high);
	}
}


void main() {
	int n, i;
	printf("enter the number of elements : ");
	scanf("%d", &n);
	
	printf("enter the data : ");
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	
	mergeSort(0, n);
	
	printf("the sorted array is : ");
	for (i = 0; i < n; i++) {
		printf("%d ", arr[i]);
	}
}