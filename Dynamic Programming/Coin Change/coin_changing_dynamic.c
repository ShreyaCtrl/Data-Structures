#include <stdio.h>
// coin changing using dynamic
int min (int a, int b) {
     if (a < b) {
          return a;
     }
     else {
          return b;
     }
}
void main() {
     int i, j, n, ch;
	 int coin[10][20];
	 int d[10];
     printf("enter the no. of denomination : ");
     scanf("%d", &n);
     for (i = 0; i < n; i++) {
          printf("enter the denomination : ");
          scanf("%d", &d[i]);
     }
     printf("enter the change : ");
     scanf("%d", &ch);
     for (i = 0; i < n; i++) {
          coin[i][0] = 0;
     }
     printf("0 |");
     for (i = 1; i <= ch; i++) {
          coin[0][i] = coin[0][i-1]+1;
          if (i <= 9)
               printf("%d |", i);
          else
               printf("%d|", i);
     }
     printf("\n");
     for (i = 1; i < n; i++) {
          for (j = 1; j <= ch; j++) {
               if (d[i] == j) {
                    coin[i][j] = 1;
               }     
               else if (d[i] > j) {
                    coin[i][j] =min(coin[i-1][j], 1+coin[i][j-1]);
               }
               else {
                    int x = j - d[i];
                    coin[i][j] = min(coin[i-1][j], 1 + coin[i][x]);
               }
          }
     }
     for (i = 0; i < n; i++) {
          for (j = 0; j <= ch; j++) {
               if (coin[i][j] < 10)
                    printf("%d |", coin[i][j]);
               else
                    printf("%d|", coin[i][j]);
          }
          printf("\n");
     }
     int no_of_coins = ch;
     for (i = 0; i < n; i++) {
          if (no_of_coins > coin[i][ch]) {
               no_of_coins = coin[i][ch];
          }
     }
     printf("%d ", no_of_coins);
}