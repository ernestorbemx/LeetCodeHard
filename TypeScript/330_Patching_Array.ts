function minPatches(nums: number[], n: number): number {
    let patches = 0;
    let k = 0; //coverage
    let lastInserted = nums[0];
    let lastIx = -1;
    while (k<n) {
        let s = k+1;
        let ix = nums.findIndex((num,i) => i>lastIx && num >= lastInserted && num<= s);
        if(ix != -1) {
            let t = nums[ix];
            console.log({ix,t,s, lastInserted, nums,k,newK: k+t})
            k = k + t;
            lastInserted = t;
            lastIx=ix;
            continue;
        }
        ix = binarySearch(nums, s);
        if(ix < 0){
            patches++;
            nums.splice(-(ix+1), 0, s); 
            lastInserted=s;
            lastIx = -(ix+1)
        } else {
            lastIx = ix;
        }
        k = k + s;
    }
    console.log({ nums, k })
    return patches;
};

function binarySearch(arr, x) {

    let start = 0, end = arr.length - 1;

    // Iterate while start not meets end
    while (start <= end) {

        // Find the mid index
        let mid = Math.floor((start + end) / 2);

        // If element is present at 
        // mid, return True
        if (arr[mid] === x) return mid;

        // Else look in left or 
        // right half accordingly
        else if (arr[mid] < x)
            start = mid + 1;
        else
            end = mid - 1;
    }

    return (-(start) -1);
}
