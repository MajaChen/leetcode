//给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。 
//
// 对于发生在时刻 t 的每个查询，需要找出在 t 时刻在选举中领先的候选人的编号。 
//
// 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。 
//
// 实现 TopVotedCandidate 类： 
//
// 
// TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。 
// int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。 
// 
//
// 示例： 
//
// 
//输入：
//["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
//[[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [
//24], [8]]
//输出：
//[null, 0, 1, 1, 0, 0, 1]
//
//解释：
//TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1,
// 0], [0, 5, 10, 15, 20, 25, 30]);
//topVotedCandidate.q(3); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
//topVotedCandidate.q(12); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
//topVotedCandidate.q(25); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在
//平局的情况下，1 是最近获得投票的候选人）。
//topVotedCandidate.q(15); // 返回 0
//topVotedCandidate.q(24); // 返回 0
//topVotedCandidate.q(8); // 返回 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= persons.length <= 5000 
// times.length == persons.length 
// 0 <= persons[i] < persons.length 
// 0 <= times[i] <= 10⁹ 
// times 是一个严格递增的有序数组 
// times[0] <= t <= 10⁹ 
// 每个测试用例最多调用 10⁴ 次 q 
// 
//
// Related Topics 设计 数组 哈希表 二分查找 👍 160 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class TopVotedCandidate {
    List<Leader> leaders;
    
    static class Candidate {
        int name;
        int count;
        
        Candidate(int name, int count) {
            this.name = name;
            this.count = count;
        }
        
        Candidate(int name) {
            this(name, 0);
        }
    }
    
    static class Vote {
        int name;
        int time;
        Vote(int name, int time) {
            this.name = name;
            this.time = time;
        }
        
        Vote(int name) {
            //this.name = name;
        }
    }
    
    class Leader {
        int time;
        Candidate candidate;
        
        Leader(int time, int name, int count) {
            this.time = time;
            this.candidate = new Candidate(name, count);
        }
        
        Leader(int time) {
            this.time = time;
        }
    }
    
    private List<Vote> buildVotes(int[] persons, int[] times) {
        List<Vote> votes = new ArrayList<>();
        for (int i = 0; i < persons.length; i++) {
            votes.add(new Vote(persons[i], times[i]));
        }
        
        Collections.sort(votes, new Comparator<Vote>() {
            @Override
            public int compare(Vote v1, Vote v2) {
                return v1.time - v2.time;
            }
        });
        
        return votes;
    }
    
    private List<Leader> buildElectionResult(int[] persons, int[] times) {
        leaders = new ArrayList<>();
        List<Vote> votes = buildVotes(persons, times);
        Candidate topCandidate = new Candidate(-1, 0);
        Map<Integer, Candidate> candidates = new HashMap<>();
        for (Vote vote : votes) {
            Candidate candidate = candidates.computeIfAbsent(vote.name, Candidate::new);
            if (++candidate.count >= topCandidate.count) {
                topCandidate = candidate;
            }
            leaders.add(new Leader(vote.time, topCandidate.name, topCandidate.count));
        }
        
        return leaders;
    }
    
    public TopVotedCandidate(int[] persons, int[] times) {
        leaders = buildElectionResult(persons, times);
    }
    
    public int q(int t) {
        int i = Collections.binarySearch(leaders, new Leader(t+1), new Comparator<Leader>() {
            @Override
            public int compare(Leader o1, Leader o2) {
                return o1.time - o2.time;
            }
        });
        
        if (i < 0) {
            i = 0-(i+1);
        }
        i = Math.min(i-1, leaders.size()-1);
        
        return leaders.get(i).candidate.name;
    }
}


/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
//leetcode submit region end(Prohibit modification and deletion)
