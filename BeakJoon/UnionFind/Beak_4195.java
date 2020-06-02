import java.io.*;

import java.util.*;

public class Beak_4195 {
	static HashMap<String, Integer> hm = new HashMap<>();
	static int cnt[];
	static int root[];

	static void union(int idx1, int idx2) {// 인덱스의 부모찾기

		idx1 = getParent(idx1);
		idx2 = getParent(idx2);

		if (idx1 != idx2) {
//순서는 안정해도 상관없음 (필요치않으면) 두노드가 이미 연결되어 있는지만확인
			root[idx2] = idx1;
			cnt[idx1] += cnt[idx2];
			cnt[idx2] = 1;

		}
		System.out.println(cnt[idx1]); // idx1하고2가 같을 경우: 어차피 같아서 뭘써도 의미없음
	}

	static int getParent(int idx) {

		if (root[idx] == idx) {
			return idx;
		}

		return root[idx] = getParent(root[idx]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int max = Integer.parseInt(br.readLine());

		for (int i = 0; i < max; i++) {
			int line = Integer.parseInt(br.readLine());
			int num = 0;
			cnt = new int[line * 2];
			root = new int[line * 2];

			for (int k = 0; k < cnt.length; k++) {
				root[k] = k;
				cnt[k] = 1;
			}

			for (int j = 0; j < line; j++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();

				if (!hm.containsKey(a)) {
					hm.put(a, num++);// 값과 인덱스 부여

				}
				int idx1 = hm.get(a);// 인덱스 가져오기

				if (!hm.containsKey(b)) {
					hm.put(b, num++);

				}
				int idx2 = hm.get(b);

				union(idx1, idx2);

			}

		}
	}

}
