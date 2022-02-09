package com.datastruct.array.puzzle;

public class RotateArray {

    public static void main(String[] args){
        int [] nums= {1,2,3,4,5,6};
        displayArray(nums);
        //rotateLeft(nums,2);
        rotateLeftRec(nums,2);
        //rotateLeftOnce(nums,0);
        rotateRightRec(nums,2);
       // rotateRightOnce(nums,nums.length-1);
        displayArray(nums);
    }

    public static int[] rotateLeft (int [] nums, int limit){
        int [] temp = new int [nums.length];
        for( int i =0; i<limit; i ++){
            temp[i]= nums[i];
        }
        displayArray(temp);
        for(int i = 0, j = limit;j< nums.length; i++,j++){
            nums[i]= nums[j];
        }
        for(int i= nums.length - limit, j=0; i< nums.length; i++, j++){
            nums[i] = temp[j];
        }

        return nums;
    }
//    public static int[] rotateLeftRec (int [] nums, int limit){
//        if(limit>0){
//            int temp = nums[0];
//            for( int i =0; i<nums.length-1; i ++){
//                nums[i]= nums[i+1];
//            }
//            nums[nums.length-1]= temp;
//            displayArray(nums);
//            return rotateLeftRec(nums,limit-1);
//        }
//        return nums;
//    }

        public static int[] rotateLeftRec (int [] nums, int limit){
        if(limit>0){
            rotateLeftOnce(nums,0);
            return rotateLeftRec(nums,limit-1);
        }
        return nums;
    }

    public static int[] rotateLeftOnce(int [] nums, int index) {
        if (nums.length-1 == index) {
            return nums;
        }
        int temp = nums[index];
        nums[index] = nums[index + 1];
        nums[index + 1] = temp;

        return rotateLeftOnce(nums, index + 1);
    }

    public static int[] rotateRightRec (int [] nums, int limit){
        if(limit > 0){
            rotateRightOnce(nums,nums.length-1);
            return rotateRightRec(nums,limit-1);
        }
        return nums;
    }

    public static int[] rotateRightOnce(int [] nums, int index) {
        if (0 == index) {
            return nums;
        }
        int temp = nums[index];
        nums[index] = nums[index - 1];
        nums[index - 1] = temp;

        return rotateRightOnce(nums, index - 1);
    }



    public static void displayArray(int [] nums){
        System.out.print("\n[");
        for (int i: nums) {

            System.out.print("\t"+ i);
        }
        System.out.print("\t]");
    }
}
