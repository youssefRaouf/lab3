package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class main implements IPlayersFinder {
	static	List <Point> points = new ArrayList () ;
	static	HashMap<String,Integer> ticked = new HashMap<>();

	public Point[] findPlayers(String[] photo, int team, int threshold) {
		int n = 0;
		int counter = 0;
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[0].length(); j++) {
				if (photo[i].charAt(j) == (char) team) {
					n = boxes(photo, i, j, (char) team);
					if (n != 0 && n * 4 >= threshold) {
					}
				}
				if (n != 0) {
					int[] arr = new int[n];
					int[] arr1 = new int[n];
					for (int l = 0; l < n; l++) {
						arr[l] = points.get(counter).x;
						arr1[l] = points.get(counter).y;
						counter++;
					}
					if (n * 4 >= threshold) {
						Point point = new Point() ;
					point.x=x(arr);
					point.y=y(arr1);

					}
				}
				n = 0;
			}
		}
   return points ;
	}

	static int y(int[] arr) {
		int max = arr[0];
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			} else if (arr[i] > max) {
				max = arr[i];
			}
		}
		min = min - 2;

		return (max + min) / 2;
	}

	static int x(int[] arr) {
		int max = arr[0];
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			} else if (arr[i] > max) {
				max = arr[i];
			}
		}
		max = max + 2;

		return (max + min) / 2;
	}

	static int boxes(String[] arr, int row, int index, char c) {
		if (index < 0 || row < 0 || row >= arr.length || index >= arr[row].length()) {
			return 0;
		}
		if (arr[row].charAt(index) == c) {
			if (!ticked.containsKey(row + "-" + index + "")) {

				Point point = new Point(index * 2, (row + 1) * 2);
				points.add(point);
				ticked.put(row + "-" + index + "", 3);
				return 1 + boxes(arr, row + 1, index, c) + boxes(arr, row, index + 1, c) + boxes(arr, row - 1, index, c)
						+ boxes(arr, row, index - 1, c);
			} else {
				return 0;
			}
		} else {

			return 0;
		}
	}

}
