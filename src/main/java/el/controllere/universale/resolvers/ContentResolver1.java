package el.controllere.universale.resolvers;

import el.controllere.universale.dto.Dto1;
import el.controllere.universale.dto.UDto;

public class ContentResolver1 implements ContentResolver {

	private Dto1 content;

	@Override
	public UDto getContent() {
		return content;
	}

	public void setContent(Dto1 content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ContentResolver1 [content=" + content + "]";
	}

}
