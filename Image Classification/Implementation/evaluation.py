loss, accuracy = model.evaluate(x_test, y_test)

print("Test Loss :", loss)
print("Test Accuracy :", accuracy)

plt.figure(figsize=(8,5))

plt.plot(history.history["accuracy"], label="Training Accuracy")
plt.plot(history.history["val_accuracy"], label="Validation Accuracy")

plt.xlabel("Epoch")
plt.ylabel("Accuracy")
plt.title("Training vs Validation Accuracy")
plt.legend()

plt.show()

plt.figure(figsize=(8,5))

plt.plot(history.history["accuracy"], label="Training Accuracy")
plt.plot(history.history["val_accuracy"], label="Validation Accuracy")

plt.xlabel("Epoch")
plt.ylabel("Accuracy")
plt.title("Training vs Validation Accuracy")
plt.legend()

plt.show()



predictions = model.predict(x_test)

predicted_labels = np.argmax(predictions, axis=1)


print(classification_report(y_test, predicted_labels, target_names=class_names))



cm = confusion_matrix(y_test, predicted_labels)

plt.figure(figsize=(10,8))

sns.heatmap(
    cm,
    annot=True,
    fmt="d",
    cmap="Blues",
    xticklabels=class_names,
    yticklabels=class_names
)

plt.xlabel("Predicted")
plt.ylabel("Actual")
plt.title("Confusion Matrix")

plt.xticks(rotation=45)
plt.yticks(rotation=0)

plt.show()


plt.figure(figsize=(12,8))

for i in range(12):

    plt.subplot(3,4,i+1)

    plt.imshow(x_test[i].reshape(28,28), cmap="gray")

    plt.title(
        f"Pred: {class_names[predicted_labels[i]]}\nTrue: {class_names[y_test[i]]}",
        fontsize=8
    )

    plt.axis("off")

plt.tight_layout()

plt.show()






