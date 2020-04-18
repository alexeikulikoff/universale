package el.controllere.universale.resolvers;

import el.controllere.universale.dto.Dto2;
import el.controllere.universale.dto.UDto;

public class ContentResolver2 implements ContentResolver {

	private Dto2 content;

	@Override
	public UDto getContent() {
		// TODO Auto-generated method stub
		return content;
	}

	public void setContent(Dto2 content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ContentResolver2 [content=" + content + "]";
	}

}
