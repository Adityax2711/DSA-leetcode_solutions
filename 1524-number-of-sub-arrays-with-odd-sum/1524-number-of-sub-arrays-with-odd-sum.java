class Solution {
	public int numOfSubarrays(int[] arr) {
		long mod = 1000000007;
		long odd=0, even=0, sum=0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
			if((sum&1)==1)odd++;
			else even++;
		}
		return (int)((odd + odd*even)%mod);
	}
}