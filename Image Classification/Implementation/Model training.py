model = Sequential()

model.add(
    Conv2D(
        32,
        (3,3),
        padding="same",
        activation="relu",
        input_shape=(28,28,1)
    )
)

model.add(BatchNormalization())

model.add(
    Conv2D(
        32,
        (3,3),
        activation="relu"
    )
)

model.add(BatchNormalization())

model.add(MaxPooling2D(pool_size=(2,2)))

model.add(Dropout(0.25))

model.add(
    Conv2D(
        64,
        (3,3),
        padding="same",
        activation="relu"
    )
)

model.add(BatchNormalization())

model.add(
    Conv2D(
        64,
        (3,3),
        activation="relu"
    )
)

model.add(BatchNormalization())

model.add(MaxPooling2D(pool_size=(2,2)))

model.add(Dropout(0.30))

model.add(
    Conv2D(
        128,
        (3,3),
        padding="same",
        activation="relu"
    )
)

model.add(BatchNormalization())

model.add(MaxPooling2D(pool_size=(2,2)))

model.add(Dropout(0.40))

model.add(Flatten())

model.add(Dense(256, activation="relu"))

model.add(Dropout(0.50))

model.add(Dense(128, activation="relu"))

model.add(Dropout(0.30))

model.add(Dense(10, activation="softmax"))

model.compile(
    optimizer=tf.keras.optimizers.Adam(learning_rate=0.001),
    loss="sparse_categorical_crossentropy",
    metrics=["accuracy"]
)
model.summary()



early_stop = EarlyStopping(
    monitor="val_accuracy",
    patience=5,
    restore_best_weights=True,
    verbose=1
)

reduce_lr = ReduceLROnPlateau(
    monitor="val_loss",
    factor=0.5,
    patience=3,
    min_lr=1e-6,
    verbose=1
)



history = model.fit(
    x_train,
    y_train,
    epochs=30,
    batch_size=64,
    validation_split=0.2,
    callbacks=[early_stop, reduce_lr]
)





















