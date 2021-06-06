package mediator;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Filter extends JTextField implements Component {
    private Mediator mediator;
    private ListModel listModel;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setListModel(ListModel listModel) {
        this.listModel = listModel;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent e) {
        String text = getText();
        searchElement(text);
    }

    private void searchElement(String text) {
        if (listModel == null) return;

        if (text.equals("")) {
            mediator.setElementsList(listModel);
            return;
        }

        ArrayList<Note> notes = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            notes.add(((Note) listModel.getElementAt(i)));
        }

        DefaultListModel<Note> listModel = new DefaultListModel<>();
        for (Note note : notes) {
            if (note.getName().contains(text)) {
                listModel.addElement(note);
            }
        }
        mediator.setElementsList(listModel);
    }

    @Override
    public String getName() {
        return "Filter";
    }
}
