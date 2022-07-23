#include<bits/stdc++.h>
class Solution {
public:
    unordered_map<string,bool>mp;
    bool isPossible(vector<int> arr, int curr_idx, int target,int n)
    {
        if(target==0)
            return true;
        
        if(curr_idx>=n)
            return false;
         
        string curr_key= to_string(curr_idx) + "_" + to_string(target);
        
        if(mp.find(curr_key)!=mp.end())
            return mp[curr_key];
        
        int consider=0;
        
        if(arr[curr_idx]<=target)
            consider= isPossible(arr,curr_idx+1,target-arr[curr_idx],n);
        
        if(consider)
        {
            mp[curr_key]=true;
            return true;
        }
        
        int notconsider=isPossible(arr,curr_idx+1,target,n);
            
        mp[curr_key]=consider||notconsider;
        
        return mp[curr_key];
    }
    bool canPartition(vector<int>& nums) {
        
        int sum=0;
        int n=nums.size();
        
        for(int i=0;i<n;i++)
            sum+= nums[i];
        
        if(sum%2!=0)
 
 return false;
        
        else
        {
            sum=sum/2;
            return isPossible(nums,0,sum,n);
        }
        
    }
};