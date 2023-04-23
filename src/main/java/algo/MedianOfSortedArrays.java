package algo;

public class MedianOfSortedArrays {

  public static void main(String[] args) {
    System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3},

        new int[]{2}));
  }

  static class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int[] combinedArray = new int[nums1.length + nums2.length];
      int index = 0;
      int i = 0;
      int j = 0;

      while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
          combinedArray[index++] = nums1[i++];
        } else {
          combinedArray[index++] = nums2[j++];
        }
      }

      if (i < nums1.length) {
        for (; i < nums1.length; i++) {
          combinedArray[index++] = nums1[i];
        }
      }

      if (j < nums2.length) {
        for (; j < nums2.length; j++) {
          combinedArray[index++] = nums2[j];
        }
      }

      if (combinedArray.length % 2 == 0) {
        return ((double) (combinedArray[combinedArray.length / 2] + combinedArray[(combinedArray.length / 2) - 1])) / 2;
      } else {
        return combinedArray[combinedArray.length / 2];
      }
    }
  }
}
