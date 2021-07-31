class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack();
        int water = 0,large=0;
        
        for(int i=0;i<height.length;i++)
        {
            if(stack.size()==0 || height[i]<=large)
            {
                stack.push(height[i]);
                if(height[i] > large)
                {
                    large = height[i];
                }
            }
            else if( height[i] > large)
            {
                while(stack.size()>0)
                {
                    water += large - stack.peek();
                    stack.pop();
                }
                stack.push(height[i]);
                large = height[i];
            }
        }
        large = 0;
        while(stack.size()>0)
        {
           if(large < stack.peek())
           {
               large = stack.peek();
           }
            water += large - stack.peek();
            stack.pop();
        }
        
        return water;
    }
}
