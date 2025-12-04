import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Solution {
    static class Log {
        int id;
        int timeStamp;
        boolean isEnd;

        public Log(int id, int timeStamp, boolean isEnd) {
            this.id = id;
            this.timeStamp = timeStamp;
            this.isEnd = isEnd;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Log> dq = new ArrayDeque<>();
        for (String log : logs) {
            Log currLog = parseLog(log);
            if (!currLog.isEnd) {
                dq.push(currLog);
            } else {
                Log prevLog = dq.pop();
                int time = currLog.timeStamp - prevLog.timeStamp + 1;
                res[currLog.id] += time;
                if (!dq.isEmpty()) {
                    res[dq.peek().id] -= time;
                }
            }
        }
        return res;
    }

    private Log parseLog(String log) {
        String[] splits = log.split(":");
        return new Log(
                Integer.parseInt(splits[0]),
                Integer.parseInt(splits[2]),
                splits[1].charAt(0) == 'e'
        );
    }
}