package com.monteiro.monitor.view;

import com.monteiro.monitor.bussines.AutoSearchService;
import com.monteiro.monitor.model.Entry;
import com.monteiro.monitor.model.Hashtag;
import com.monteiro.monitor.repository.EntryRepo;
import com.monteiro.monitor.repository.HashtagRepo;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author vicente.monteiro
 */
@Route
public class MainView extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    @Autowired
    EntryRepo entryDAO;

    @Autowired
    HashtagRepo hashtagDAO;

    @Autowired
    AutoSearchService autoService;

    private HorizontalLayout deleteLayout;
    private ComboBox<Hashtag> hashCombo;
    private Button deleteButton;
    private Grid<Entry> entryGrid;

    private HorizontalLayout insertLayout;
    private TextField hashText;
    private Button insertButton;

    public MainView() {
    }

    @PostConstruct
    private void init() {
        this.setSpacing(true);
        this.initInsertLayout();
        this.initViewLayout();
    }

    private void initViewLayout() {
        this.deleteButton = new Button("Remover", new ComponentEventListener<ClickEvent<Button>>() {

            @Transactional
            @Override
            public void onComponentEvent(final ClickEvent<Button> event) {
                final Hashtag tag = MainView.this.hashCombo.getValue();
                MainView.this.entryDAO.deleteInBatch(MainView.this.entryDAO.findAllByTag(tag));
                MainView.this.hashtagDAO.delete(tag);

                MainView.this.refreshHashCombo();
            }
        });

        this.hashCombo = new ComboBox("Hashtags Monitoradas", this.hashtagDAO.findAll());
        this.hashCombo.addValueChangeListener(event -> {
            entryGrid.setItems(this.entryDAO.findAllByTag(this.hashCombo.getValue()));
        });

        this.hashCombo.setItemLabelGenerator(Hashtag::getName);

        this.deleteLayout = new HorizontalLayout(this.hashCombo, this.deleteButton);
        this.deleteLayout.setSpacing(true);
        this.add(this.deleteLayout);

        this.entryGrid = new Grid();
        this.entryGrid.addColumn(Entry::getInsertDate).setHeader("Data").setResizable(true);
        this.entryGrid.addColumn(Entry::getAuthor).setHeader("Autor").setResizable(true);
        this.entryGrid.addColumn(Entry::getBody).setHeader("Mensagem").setResizable(true);

        this.add(this.entryGrid);
    }

    private void initInsertLayout() {
        this.insertButton = new Button("Inserir", event -> {
            MainView.this.hashtagDAO.save(new Hashtag(MainView.this.hashText.getValue()));
            MainView.this.hashText.clear();

            MainView.this.refreshHashCombo();
            this.autoService.proceedNewTag();
        });

        this.hashText = new TextField("Nova Hashtag");

        this.insertLayout = new HorizontalLayout(this.hashText, this.insertButton);
        this.insertLayout.setSpacing(true);
        this.add(this.insertLayout);
    }

    private void refreshHashCombo() {
        this.hashCombo.setItems(this.hashtagDAO.findAll());
    }

}
