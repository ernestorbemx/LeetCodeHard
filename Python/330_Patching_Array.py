class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        patches = 0
        k = 0
        lastInserted = nums[0]
        lastIx = -1
        while (k<n):
            s = k+1
            # print({'lower':lastInserted, 'upper': s, 'nums': nums, 'lastIx': lastIx})
            ixs = [i for i in range(len(nums)) if i > lastIx and  nums[i] >= lastInserted and nums[i] <= s]
            if (len(ixs) > 0):
                ix = ixs[0]
                t=nums[ix]
                # print(ixs)
                # print({ 'ix': ix, 't': t, 'k': k, 's': s})
                k = k +t
                lastInserted=t
                lastIx=ix
                continue

            ix = self.binarySearch(nums,s)
            # print({'ix':ix, 's': s})
            if(ix<0):
                patches = patches + 1
                nums.insert(-(ix+1),s)
                lastInserted = s
                lastIx = -(ix +1)
            else:
                lastIx = ix
            
            k = k+s
        
        return patches


    def binarySearch(self, arr: List[int], n: int):
        start=0
        end=len(arr)-1
        while start <= end:
            mid = math.floor((start+end) /2 )

            if(arr[mid] == n): return mid
            elif(arr[mid] < n ): start = mid+1
            else: end = mid-1

        return (-(start)-1)


        
