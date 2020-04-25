package el.controllere.universale;

import java.util.ArrayList;
import java.util.List;

public class GroupNode {

	private Long p;
	private String name;
	private String code;
	private Long q;
	private List<GroupNode> nodes = new ArrayList<>();

	public GroupNode(Long p, String name, String code, Long q) {
		super();
		this.p = p;
		this.name = name;
		this.code = code;
		this.q = q;
	}

	public void addNode(GroupNode node) {
		nodes.add(node);
	}

	public Long getP() {
		return p;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public Long getQ() {
		return q;
	}

	public List<GroupNode> getNodes() {
		return nodes;
	}

	@Override
	public String toString() {

		String s = "\n";
		for (GroupNode node : nodes) {
			s = s + "[ p=" + node.getP() + ", q= " + node.getQ() + "]\n";
			if (node.getNodes() != null) {

			}

		}
		return "GroupNode [p=" + p + "  q=" + q + ", \nnodes=" + s + "]\n";
	}

}
