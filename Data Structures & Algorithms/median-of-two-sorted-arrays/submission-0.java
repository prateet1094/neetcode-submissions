class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)return findMedianSortedArrays(nums2,nums1);

        int left = 0;
        int right = nums1.length;
        int totalElements = (nums1.length + nums2.length);
        int n = (1+ totalElements)/2;
              

        while(left<=right){
            int mid = left + (right-left)/2;

            int elementsInNums2 = n-mid;

            int l1 = mid>=1?nums1[mid-1]:Integer.MIN_VALUE;
            int r1 = mid<nums1.length?nums1[mid]:Integer.MAX_VALUE;

            int l2 = elementsInNums2-1>=0?nums2[elementsInNums2-1]:Integer.MIN_VALUE;
            int r2 = elementsInNums2<nums2.length?nums2[elementsInNums2]:Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1){
                if(totalElements%2==0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                } else {
                    return Math.max(l1,l2);
                }
            } else if(l1>r2){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return 0.0;
        
    }
}
