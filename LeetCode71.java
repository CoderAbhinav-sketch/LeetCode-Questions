/*

71. Simplify Path (Medium Level )

// 

You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.

The rules of a Unix-style file system are as follows:

A single period '.' represents the current directory.
A double period '..' represents the previous/parent directory.
Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
The simplified canonical path should follow these rules:

The path must start with a single slash '/'.
Directories within the path must be separated by exactly one slash '/'.
The path must not end with a slash '/', unless it is the root directory.
The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
Return the simplified canonical path.

 

Example 1:

Input: path = "/home/"

Output: "/home"

Explanation:

The trailing slash should be removed.

Example 2:

Input: path = "/home//foo/"

Output: "/home/foo"

Explanation:

Multiple consecutive slashes are replaced by a single one.

Example 3:

Input: path = "/home/user/Documents/../Pictures"

Output: "/home/user/Pictures"

Explanation:

A double period ".." refers to the directory up a level (the parent directory).

Example 4:

Input: path = "/../"

Output: "/"

Explanation:

Going one level up from the root directory is not possible.

Example 5:

Input: path = "/.../a/../b/c/../d/./"

Output: "/.../b/d"

Explanation:

"..." is a valid name for a directory in this problem.
 */
// This problen are solve a stack by LIFO property
class Solution {
    public String simplifyPath(String path) {
        // Step 1 : create string deque
        // step 2 : create string array to split string
        // traversal 
        // step 3 isempty-- Ignore
        // step 4 if(st.equal("."))-- Ignore
        // step 5 if(st.equal("..") && st.isEmpty())--Ignore
        // step 6 if(st.equal("..") && !st.isEmpty()) -- pop()else push
        // step 6 reverse
        // . isEmpty -- return = "/"
        // step 7 Create StringBuilder to store ans;
        // while(!st.isEmpty()) str.append('/') str.append(st.removeLast)
        // step 8 return.str.toString;

        Deque<String> st = new ArrayDeque<>();
        String[] parts = path.split("/");
        for(String part : parts){
            if(part.isEmpty()){
                continue;
            }
            if(part.equals(".")){
                continue;
            }
            if(part.equals("..") && st.isEmpty()){
                continue;
            }

            if(part.equals("..") && !st.isEmpty()){
                st.pop();
            }else{
                st.push(part);
            }
        }
        if(st.isEmpty()){
            return "/";
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append("/");
            str.append(st.removeLast());
        }
        return str.toString();
    }
}

// Time Complexity = O(N)
// Space Complexity = O(N)