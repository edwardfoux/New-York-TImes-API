package com.example.edwardfoux.opentablenytimes.main_view;
import com.example.edwardfoux.opentablenytimes.model.DvdPick;
import com.example.edwardfoux.opentablenytimes.model.NYTimesResponse;
import com.example.edwardfoux.opentablenytimes.network.DataModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;

public class ViewModelTest {

    private MainView viewMock;
    private DataModel model;
    private TestScheduler testScheduler;
    private DvdViewModel viewModel;

    @Before
    public void setup() {
        model = Mockito.mock(DataModel.class);
        viewMock = Mockito.mock(MainView.class);
        testScheduler = new TestScheduler();
        viewModel = new DvdViewModel();
    }

    @Test
    public void test() {
        // Setup
        Mockito.when(viewMock.isNetworkAvailable()).thenReturn(true);
        NYTimesResponse response = new NYTimesResponse();
        List<DvdPick> data = new ArrayList<>();
        response.setResults(data);
        Mockito.doReturn(Observable.just(response)).when(model).getDvdPicks(ArgumentMatchers
                .anyString(), ArgumentMatchers.anyString());

        // Execute
        viewModel.setView(viewMock, model, testScheduler, testScheduler);
        viewModel.loadData();
        testScheduler.triggerActions();

        // Verify
        Mockito.verify(viewMock, Mockito.times(1)).onDataAvailable(data);
    }

    @Test
    public void testNoNetwork() {
        // Setup
        Mockito.when(viewMock.isNetworkAvailable()).thenReturn(false);

        // Execute
        viewModel.setView(viewMock, model, testScheduler, testScheduler);
        viewModel.loadData();

        // Verify
        Mockito.verify(viewMock, Mockito.times(1)).showErrorMessage(ArgumentMatchers.anyInt());
    }
}
