# Local RAG Chatbot with LangChain & Ollama

A Retrieval-Augmented Generation (RAG) chatbot that enables users to interact with their own documents using natural language. The application processes uploaded documents, converts them into vector embeddings, retrieves the most relevant information using semantic search, and generates context-aware responses through a locally hosted Large Language Model (LLM) using Ollama. The entire pipeline runs locally, ensuring data privacy without relying on external APIs.

---

## Overview

Traditional Large Language Models (LLMs) generate responses based only on their pre-trained knowledge and cannot directly access user-specific documents. This project addresses that limitation by implementing a **Retrieval-Augmented Generation (RAG)** pipeline that retrieves relevant information from uploaded documents before generating a response.

The chatbot supports multiple document uploads, semantic similarity search using FAISS, and context-aware answer generation through a locally hosted Llama 3.2 model. This approach improves response accuracy while maintaining complete offline functionality and data privacy.

---

## Objective

- Build a complete Retrieval-Augmented Generation (RAG) chatbot from scratch.
- Enable question answering over multiple user-provided documents.
- Implement semantic search using vector embeddings and FAISS.
- Generate context-aware responses using a locally hosted Large Language Model.
- Maintain conversation history for multi-turn interactions.
- Provide an intuitive web interface using Streamlit.
- Execute the complete workflow locally without requiring external APIs.

---

## Technologies Used

| Category | Technology |
|----------|------------|
| Programming Language | Python |
| Framework | LangChain |
| Embedding Model | HuggingFace Sentence Transformers (`all-MiniLM-L6-v2`) |
| Vector Database | FAISS |
| Large Language Model | Llama 3.2 (Ollama) |
| Frontend | Streamlit |
| Document Loader | PyPDF |

---

## Methodology

The chatbot follows a **Retrieval-Augmented Generation (RAG)** pipeline to provide accurate and context-aware responses from user-provided documents.

### 1. Document Loading & Preprocessing
- Load multiple PDF and text documents from the input directory.
- Extract textual content using document loaders.
- Split the extracted text into overlapping chunks using recursive text splitters to preserve semantic context and improve retrieval performance.

### 2. Embedding Generation & Vector Storage
- Generate dense vector embeddings for each text chunk using the **HuggingFace Sentence Transformers** model (`all-MiniLM-L6-v2`).
- Store the generated embeddings in a local **FAISS** vector database for efficient semantic retrieval.

### 3. Retrieval Pipeline
- Convert the user's query into an embedding using the same embedding model.
- Perform similarity search on the FAISS index to retrieve the most relevant document chunks.
- Use the retrieved chunks as contextual knowledge for response generation.

### 4. Response Generation
- Combine the retrieved document context with the user's query to construct a prompt.
- Generate grounded responses using a locally hosted **Llama 3.2** model through **Ollama**, ensuring answers are based on the uploaded documents.

### 5. Conversational Memory
- Maintain conversation history to support follow-up questions and multi-turn interactions.
- Incorporate previous chat history into the prompt for improved contextual understanding.

### 6. Web Application
- Provide an interactive **Streamlit** interface for document upload, chatbot interaction, and conversation management.
- Execute the complete RAG workflow locally without requiring external cloud APIs.

---

## Workflow

```text
User Uploads Documents
          │
          ▼
Document Loading & Preprocessing
          │
          ▼
Text Chunking
          │
          ▼
Embedding Generation
          │
          ▼
FAISS Vector Database
          │
          ▼
Similarity Retrieval
          │
          ▼
Prompt Construction
          │
          ▼
Ollama (Llama 3.2)
          │
          ▼
Response Generation
          │
          ▼
Conversation Memory
          │
          ▼
Streamlit Web Interface
```

---

## Features

- Upload and process multiple PDF documents.
- Automatic document chunking and preprocessing.
- Semantic similarity search using FAISS.
- Dense vector embedding generation with Sentence Transformers.
- Context-aware response generation using a local Llama 3.2 model.
- Multi-turn conversational memory.
- Interactive Streamlit-based chatbot interface.
- Fully offline execution without requiring paid APIs.
- Modular and scalable architecture for future enhancements.

---

## Result Obtained

The developed application successfully implements an end-to-end Retrieval-Augmented Generation pipeline capable of answering user queries based on uploaded documents. User documents are processed into semantic embeddings, indexed in a FAISS vector database, and retrieved using similarity search to provide relevant context for response generation.

The chatbot generates accurate, context-aware responses using the locally hosted **Llama 3.2** model through Ollama, ensuring that answers are grounded in the uploaded documents rather than relying solely on pre-trained knowledge. The Streamlit interface enables users to upload documents, ask questions, and engage in natural multi-turn conversations, demonstrating the effectiveness of combining semantic retrieval with modern language models for document-based question answering.
