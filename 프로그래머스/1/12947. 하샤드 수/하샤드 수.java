class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        char[] arr = Integer.toString(x).toCharArray();
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            sum += arr[i] - '0';
        }
        
        System.out.println(sum);
        
        if (x % sum != 0){
            answer = false;
        }
        
        return answer;
    }
}