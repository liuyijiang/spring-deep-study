package com.method;
/**
 * 桶排序
 * @author Administrator
 *
 */
public class TestBucketSortTest {

	public void bucketSort(){
		int max = 10;
    	int min = 0;
    	int[] data= new int[] { 5, 3, 6, 2, 1, 9, 4, 4, 4, 8, 7 };
    	int[] tmp =new int[data.length];
    	int[] buckets = new int[max - min];
    	
    	 for (int i= 0; i < data.length; i++) {
             buckets[data[i] - min]++;
          }
    	 // 计算“落入”各桶内的元素在有序序列中的位置
    	 for (int i= 1; i < max - min; i++) {
             buckets[i] = buckets[i] + buckets[i - 1];
          }
    	 // 将data中的元素完全复制到tmp数组中

	       System.arraycopy(data, 0, tmp, 0, data.length);

	        // 根据buckets数组中的信息将待排序列的各元素放入相应位置

	        for (int k= data.length - 1; k >= 0; k--) {

	           data[--buckets[tmp[k] - min]] = tmp[k];

	        }
	        
	        for (int i= 0; i < data.length; i++) {

	            System.out.print(data[i] + "\t");

	         }
	}
	
	public static void main(String[] args) {
		TestBucketSortTest t = new TestBucketSortTest();
		t.bucketSort();
	}
	
}
