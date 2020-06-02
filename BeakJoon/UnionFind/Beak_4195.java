import java.io.*;

import java.util.*;

public class Beak_4195 {
	static HashMap<String, Integer> hm = new HashMap<>();
	static int cnt[];
	static int root[];

	static void union(int idx1, int idx2) {// �ε����� �θ�ã��

		idx1 = getParent(idx1);
		idx2 = getParent(idx2);

		if (idx1 != idx2) {
//������ �����ص� ������� (�ʿ�ġ������) �γ�尡 �̹� ����Ǿ� �ִ�����Ȯ��
			root[idx2] = idx1;
			cnt[idx1] += cnt[idx2];
			cnt[idx2] = 1;

		}
		System.out.println(cnt[idx1]); // idx1�ϰ�2�� ���� ���: ������ ���Ƽ� ���ᵵ �ǹ̾���
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
					hm.put(a, num++);// ���� �ε��� �ο�

				}
				int idx1 = hm.get(a);// �ε��� ��������

				if (!hm.containsKey(b)) {
					hm.put(b, num++);

				}
				int idx2 = hm.get(b);

				union(idx1, idx2);

			}

		}
	}

}
