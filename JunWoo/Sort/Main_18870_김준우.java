import java.util.Scanner;

public class Main_18870_±èÁØ¿ì {
    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        sort(arr, 0, mid);
        sort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end- start];
        int t = 0, l = start, h = mid;

        while (l < mid && h < end) {
            if (arr[l] < arr[h]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[h++];
            }
        }

        while (l < mid) {
            temp[t++] = arr[l++];
        }

        while (h < end) {
            temp[t++] = arr[h++];
        }

        for (int i = start; i < end; i++) {
            arr[i] = temp[i - start];
        }
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] in = new int[N];
		int[] out = new int[N];
		for(int i = 0; i<N; i++) {
			in[i] = sc.nextInt();
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0;j<N;j++) {
				if(in[i]>in[j]) {
					out[i]++;
				}
			}
			sb.append(out[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}

/*
public class Main_18870 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] in = new int[N];
		int[] out = new int[N];
		for(int i = 0; i<N; i++) {
			in[i] = sc.nextInt();
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0;j<N;j++) {
				if(in[i]>in[j]) {
					out[i]++;
				}
			}
			sb.append(out[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}

}
 */