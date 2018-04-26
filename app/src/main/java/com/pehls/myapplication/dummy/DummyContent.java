package com.pehls.myapplication.dummy;

import com.pehls.myapplication.dados.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Book> ITEMS = new ArrayList<Book>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Book> ITEM_MAP = new HashMap<String, Book>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(Book item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getNome(), item);
    }

    private static Book createDummyItem(int position) {
        return new Book( "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Autor do livro ").append(position);
        builder.append("\nPara mais detalhes, clique aqui :)");
        return builder.toString();
    }

}
