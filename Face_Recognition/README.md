# Face Recognition using Convolutional Neural Network (CNN)

## Objective

Develop a Convolutional Neural Network (CNN) model to recognize and classify human faces using the Labeled Faces in the Wild (LFW) dataset.

---

## Dataset

**Labeled Faces in the Wild (LFW)**

The dataset is loaded using the `fetch_lfw_people()` function from the `scikit-learn` library.

Dataset Features:
- Grayscale face images
- Multiple face classes
- Face images resized for efficient model training

---

## Libraries Used

- numpy
- matplotlib
- tensorflow
- scikit-learn
- seaborn

---

## Methodology

1. Import the required libraries.
2. Load the LFW face dataset.
3. Visualize sample face images.
4. Preprocess the dataset by:
   - Normalizing pixel values.
   - Reshaping images.
   - One-hot encoding target labels.
5. Split the dataset into training and testing sets.
6. Build a CNN architecture consisting of:
   - Convolutional Layers
   - MaxPooling Layers
   - Flatten Layer
   - Dense Layers
   - Softmax Output Layer
7. Compile the model using the Adam optimizer and categorical cross-entropy loss.
8. Train the CNN model.
9. Evaluate the model using the test dataset.
10. Generate the confusion matrix and classification report.
11. Predict face classes for unseen test images.
12. Save and reload the trained model.

---

## Model Architecture

- Conv2D (32 Filters)
- MaxPooling2D
- Conv2D (64 Filters)
- MaxPooling2D
- Flatten
- Dense Layer
- Softmax Output Layer

---

## Results

### Test Accuracy

| Metric | Value |
| :----- | ----: |
| Test Accuracy | **87.60%** |

### Classification Report

| Class | Precision | Recall | F1-Score |
| :---- | --------: | -----: | -------: |
| Ariel Sharon | 0.87 | 0.81 | 0.84 |
| Colin Powell | 0.88 | 0.96 | 0.92 |
| Donald Rumsfeld | 0.95 | 0.75 | 0.84 |
| George W. Bush | 0.93 | 0.94 | 0.93 |
| Gerhard Schroeder | 0.66 | 0.86 | 0.75 |
| Hugo Chavez | 1.00 | 0.79 | 0.88 |
| Tony Blair | 0.80 | 0.69 | 0.74 |

### Overall Performance

| Metric | Value |
| :----- | ----: |
| Accuracy | **0.88** |
| Macro Precision | **0.87** |
| Macro Recall | **0.83** |
| Macro F1-Score | **0.84** |
| Weighted Precision | **0.88** |
| Weighted Recall | **0.88** |
| Weighted F1-Score | **0.88** |

The CNN model achieved a **test accuracy of 87.60%**, demonstrating effective facial recognition performance on the LFW dataset. The classification report shows strong precision, recall, and F1-scores across most face classes, with the highest precision achieved for **Hugo Chavez (1.00)** and the highest recall for **Colin Powell (0.96)**.

---

## Conclusion

A Convolutional Neural Network (CNN) was successfully developed for face recognition using the Labeled Faces in the Wild (LFW) dataset. The model learned facial features through convolutional and pooling layers and achieved a **test accuracy of 87.60%**. Performance evaluation using the classification report and confusion matrix demonstrated that the model classified most face categories accurately. CNNs automatically extract meaningful image features, making them highly effective for face recognition tasks. Although the model performed well overall, additional training data and deeper network architectures could further improve classification performance for classes with fewer samples.

---

## Repository Structure

```
Face-Recognition/
│── Face_Recognition.ipynb
│── README.md
└── face_recognition_model.keras
```
