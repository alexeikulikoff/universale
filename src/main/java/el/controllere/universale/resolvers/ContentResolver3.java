package el.controllere.universale.resolvers;

import el.controllere.universale.dto.Dto3;
import el.controllere.universale.dto.UDto;

public class ContentResolver3
		implements ContentResolver
{

	private Dto3 content;

	@Override
	public UDto getContent() {
		// TODO Auto-generated method stub
		return content;
	}

	public void setContent(Dto3 content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ContentResolver3 [content=" + content + "]";
	}

}
