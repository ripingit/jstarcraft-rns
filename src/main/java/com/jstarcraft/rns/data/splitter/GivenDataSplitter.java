package com.jstarcraft.rns.data.splitter;

import com.jstarcraft.ai.data.DataModule;
import com.jstarcraft.ai.data.module.ReferenceModule;
import com.jstarcraft.ai.utility.IntegerArray;

/**
 * 指定数据处理器
 * 
 * @author Birdy
 *
 */
// TODO 准备改名为SpecificThresholdSplitter
public class GivenDataSplitter implements DataSplitter {

    private DataModule dataModel;

    private IntegerArray trainReference;

    private IntegerArray testReference;

    public GivenDataSplitter(DataModule model, int threshold) {
        dataModel = model;
        trainReference = new IntegerArray();
        testReference = new IntegerArray();
        int size = model.getSize();
        for (int index = 0; index < size; index++) {
            if (index < threshold) {
                trainReference.associateData(index);
            } else {
                testReference.associateData(index);
            }
        }
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public DataModule getDataModel() {
        return dataModel;
    }

    @Override
    public ReferenceModule getTrainReference(int index) {
        return new ReferenceModule(trainReference, dataModel);
    }

    @Override
    public ReferenceModule getTestReference(int index) {
        return new ReferenceModule(testReference, dataModel);
    }

}
