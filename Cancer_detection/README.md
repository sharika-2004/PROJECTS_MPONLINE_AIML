# Brain MRI Tumor Classification using Convolutional Neural Network (CNN)

## Objective

Develop a Convolutional Neural Network (CNN) model to classify Brain MRI images into four categories: **Glioma**, **Meningioma**, **No Tumor**, and **Pituitary Tumor**.

---

## Dataset

Brain MRI Images Dataset

The dataset consists of four classes:

- Glioma
- Meningioma
- No Tumor
- Pituitary Tumor

The images are preprocessed by resizing, normalizing pixel values, and splitting into training and testing datasets.

---

## Libraries Used

- numpy
- matplotlib
- tensorflow
- scikit-learn
- seaborn
- opencv-python

---

## Methodology

1. Import the required libraries.
2. Load the Brain MRI image dataset.
3. Preprocess the images by:
   - Resizing the images.
   - Normalizing pixel values.
   - Encoding class labels.
4. Split the dataset into training and testing sets.
5. Build a Convolutional Neural Network (CNN) consisting of:
   - Convolutional Layers
   - MaxPooling Layers
   - Flatten Layer
   - Dense Layers
   - Softmax Output Layer
6. Compile the model using the Adam optimizer and categorical cross-entropy loss.
7. Train the CNN model.
8. Evaluate the model on the test dataset.
9. Generate:
   - Accuracy and Loss graphs
   - Confusion Matrix
   - Classification Report
10. Predict tumor classes for unseen MRI images.
11. Save the trained CNN model.

---

## Model Architecture

- Conv2D (32 Filters)
- MaxPooling2D
- Conv2D (64 Filters)
- MaxPooling2D
- Flatten
- Dense Layer
- Dropout Layer
- Output Layer (Softmax)

---

## Results

### Test Performance

| Metric | Value |
| :----- | ----: |
| Test Accuracy | **90.25%** |
| Test Loss | **0.8795** |

### Classification Report

| Class | Precision | Recall | F1-Score |
| :---- | --------: | -----: | -------: |
| Glioma | 0.91 | 0.76 | 0.83 |
| Meningioma | 0.87 | 0.89 | 0.88 |
| No Tumor | 0.87 | 0.99 | 0.93 |
| Pituitary | 0.96 | 0.97 | 0.97 |

### Overall Performance

| Metric | Value |
| :----- | ----: |
| Accuracy | **90%** |
| Macro Precision | **0.90** |
| Macro Recall | **0.90** |
| Macro F1-Score | **0.90** |
| Weighted Precision | **0.90** |
| Weighted Recall | **0.90** |
| Weighted F1-Score | **0.90** |

The CNN model achieved a **test accuracy of 90.25%**, demonstrating strong performance in classifying Brain MRI images into four tumor categories. The highest classification performance was achieved for the **Pituitary Tumor** class with an F1-score of **0.97**, while the **No Tumor** class obtained the highest recall of **0.99**.

---

## Conclusion

A Convolutional Neural Network (CNN) was successfully developed to classify Brain MRI images into four diagnostic categories. The model automatically extracted important image features through convolutional and pooling layers and achieved a **test accuracy of 90.25%**. The confusion matrix and classification report demonstrated balanced performance across all classes, with particularly high performance for detecting Pituitary tumors and No Tumor cases. CNN-based image classification provides an effective approach for assisting medical image analysis and can support early brain tumor diagnosis.


