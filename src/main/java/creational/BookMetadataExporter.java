package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {
    public abstract void export(PrintStream stream);
    public abstract void add(Book b);
}

//XML
class XMLBookMetadataExporter extends BookMetadataExporter {
    BookMetadataFormatter bookMetadataFormatter = new XMLBookMetadataFormatter();

    XMLBookMetadataExporter() throws ParserConfigurationException {
    }

    @Override
    public void export(PrintStream stream) {
        stream.println(bookMetadataFormatter.getMetadataString());
    }

    @Override
    public void add(Book b) {
        bookMetadataFormatter.append(b);
    }
}

//CSV
class CSVBookMetadataExporter extends BookMetadataExporter {
    BookMetadataFormatter bookMetadataFormatter = new CSVBookMetadataFormatter();

    CSVBookMetadataExporter() throws IOException {
    }

    @Override
    public void export(PrintStream stream) {
        stream.println(bookMetadataFormatter.getMetadataString());
    }

    @Override
    public void add(Book b) {
        bookMetadataFormatter.append(b);
    }
}

//JSON
class JSONBookMetadataExporter extends BookMetadataExporter {
    BookMetadataFormatter bookMetadataFormatter = new JSONBookMetadataFormatter();

    JSONBookMetadataExporter() throws IOException {
    }

    @Override
    public void export(PrintStream stream) {
        stream.println(bookMetadataFormatter.getMetadataString());
    }

    @Override
    public void add(Book b) {
        bookMetadataFormatter.append(b);
    }
}