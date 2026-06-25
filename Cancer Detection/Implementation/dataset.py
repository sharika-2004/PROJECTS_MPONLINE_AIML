def generate_realistic_medical_images(num_samples=1000, img_size=(128, 128)):
    np.random.seed(42)
    X = np.random.randn(num_samples, img_size[0], img_size[1], 3).astype(np.float32)
    y = np.random.randint(0, 2, size=(num_samples,))
    
    for i in range(num_samples):
        if y[i] == 1:
            X[i, 40:80, 40:80, 0] += 1.4
        else:
            X[i, :, :, 1] += 0.3
            
    noise = np.random.normal(0, 0.6, X.shape)
    X = X + noise
    X = (X - X.min()) / (X.max() - X.min())
    return X, y

X, y = generate_realistic_medical_images()
X_train, X_val, y_train, y_val = train_test_split(X, y, test_size=0.2, random_state=42)

print(f"Train samples: {X_train.shape[0]}, Validation samples: {X_val.shape[0]}")
