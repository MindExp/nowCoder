### DP 专栏
#### 53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
* [53](./DP/Question_53.java)
* [leetcode](https://leetcode-cn.com/problems/maximum-subarray/)

#### 77_1. 最长公共子序列
给定两个字符串，返回长公共子序列长度
* [77_1](./DP/Question_77_1.java)
* [lintcode](https://www.lintcode.com/problem/longest-common-subsequence/description)

#### 77_2. 最长公共子串
给定两个字符串，返回长公共子串长度
* [77_2](./DP/Question_77_2.java)
* [lintcode](https://www.lintcode.com/problem/longest-common-substring/description)

#### 5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
* [5](./leetcode/Question_5.java)
* [leetcode](https://leetcode-cn.com/problems/longest-palindromic-substring/solution/)

#### 62. 不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。问总共有多少条不同的路径？
* [62](./DP/Question_62.java)
* [leetcode](https://leetcode-cn.com/problems/unique-paths/)

#### 63. 不同路径 II
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
网格中的障碍物和空位置分别用 1 和 0 来表示。
* [63](./DP/Question_63.java)
* [leetcode](https://leetcode-cn.com/problems/unique-paths-ii)

#### 64. 矩阵的最小路径和
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
* [64](./DP/Question_64.java)
* [leetcode](https://leetcode-cn.com/problems/minimum-path-sum/description/)

#### 70. 爬楼梯
假设你正在爬楼梯，需要 n 阶你才能到达楼顶，每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
* [70](./DP/Question_70.java)
* [leetcode](https://leetcode-cn.com/problems/climbing-stairs/)

#### 72. 编辑距离问题：
字符串之间的距离，编辑距离，将strA编辑成strB所需的最小代价，编辑操作包括插入一个字符、删除一个字符、替换一个字符。
* [72](./DP/Question_72.java)
* [leetcode](https://leetcode-cn.com/problems/edit-distance/)

#### 198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
* [198](./DP/Question_198.java)
* [leetcode](https://leetcode-cn.com/problems/house-robber/)

#### 213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
* [213](./DP/Question_213.java)
* [leetcode](https://leetcode-cn.com/problems/house-robber-ii)

#### 信件错排
有 N 个 信 和 信封，它们被打乱，求错误装信方式的数量。 

状态转移方程：dp[i] = (i - 1) * dp[i - 2] + (i - 1) * dp[ i - 1]

#### 母牛生产
假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。

状态转移方程：dp[i] = dp[i - 3] + dp[i - 1]

#### 0-1 背包问题

* [ZeroOnePack_1](./DP/ZeroOnePack_1.java)

####  多重背包问题 与 完全背包问题
1）多重背包问题：每类物品都有个数限制，第 i 类物品最多可以装 num[i] 次

2）完全背包：每类物品可以无限次装进包内
* [ZeroOnePack_2](./DP/ZeroOnePack_2.java)

#### 

* []()
* [leetcode](./DP/)

#### 

* []()
* [leetcode](./DP/)

#### 

* []()
* [leetcode](./DP/)

#### 

* []()
* [leetcode](./DP/)

#### 

* []()
* [leetcode](./DP/)

#### 

* []()
* [leetcode](./DP/)

#### 

* []()
* [leetcode](./DP/)

#### 

* []()
* [leetcode](./DP/)

#### 

* []()
* [leetcode](./DP/)

### 回溯 专栏
#### 51. N皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
* [51](./leetcode/Question_51.java)
* [leetcode](https://leetcode-cn.com/problems/n-queens-ii/)





#### 945. 使数组唯一的最小增量
给定整数数组A，每次 move 操作将会选择任意A[i]，并将其递增1，返回使 A 中的每个值都是唯一的最少操作次数。
* [945](./leetcode/Question_945.java)
* [leetcode](https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique)

#### 50. Pow(x, n) 幂计算
实现 pow(x, n) ，即计算 x 的 n 次幂函数。
* [50](./leetcode/Question_50.java)
* [leetcode](https://leetcode-cn.com/problems/powx-n/)

#### 372. 超级次方 (a^b) mod c
你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
* [372](./leetcode/Question_372.java)
* [leetcode](https://leetcode-cn.com/problems/super-pow/)

#### 54. 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
* [54](./leetcode/Question_54.java)
* [leetcode](https://leetcode-cn.com/problems/spiral-matrix/)

#### 59. 螺旋矩阵 II
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
* [59](./leetcode/Question_59.java)
* [leetcode](https://leetcode-cn.com/problems/spiral-matrix-ii/)

#### 138. 复制带随机指针的链表
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。要求返回这个链表的深拷贝。 
* [138](./coding_interviews/Question_35.java)
* [leetcode](https://leetcode-cn.com/problems/copy-list-with-random-pointer/)

#### 91. 解码方法
一条包含字母 A-Z 的消息通过以下方式进行了编码：
     'A' -> 1
     'B' -> 2
     ...
     'Z' -> 26
* [91](./leetcode/Question_91.java)
* [leetcode](https://leetcode-cn.com/problems/decode-ways/)

#### 124. 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
* [124](./leetcode/Question_124.java)
* [leetcode](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)

#### 862. 和至少为 K 的最短子数组
返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。如果没有和至少为 K 的非空子数组，返回 -1 。
* [862]()
* [leetcode](https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/)

#### 9. 回文数
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
* [9](./leetcode/Question_9.java)
* [leetcode](https://leetcode-cn.com/problems/palindrome-number/)

#### 236. 二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
* [236](./leetcode/Question_236.java)
* [leetcode](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

#### 

* []()
* [leetcode]()

#### 

* []()
* [leetcode]()

#### 

* []()
* [leetcode]()

#### 

* []()
* [leetcode]()

#### 

* []()
* [leetcode]()

#### 

* []()
* [leetcode]()