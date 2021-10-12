package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject jsonObject;
    private JSONArray jsonArray;

    public JSONBookMetadataFormatter() throws IOException {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        jsonObject = new JSONObject();
        jsonArray = new JSONArray();
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        JSONObject book = new JSONObject();

        book.put("ISBN", b.getISBN());

        JSONArray authors = new JSONArray();
        for (String author : b.getAuthors()) {
            authors.add(author);
        }
        book.put("Authors", authors);

        book.put("Title", b.getTitle());
        book.put("Publisher", b.getPublisher());

        jsonArray.add(book);
        jsonObject.put("Books", jsonArray);
        return this;
    }

    @Override
    public String getMetadataString() {
        return jsonObject.toJSONString()+"\n";
    }
}
