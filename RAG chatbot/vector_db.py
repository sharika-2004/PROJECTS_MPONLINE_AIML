import os
from load_and_split import load_and_split_documents
from langchain_huggingface import HuggingFaceEmbeddings
from langchain_community.vectorstores import FAISS

DB_FAISS_PATH = "vectorstore/db_faiss"

def create_vector_db():
   
    splits = load_and_split_documents()

 
    embeddings = HuggingFaceEmbeddings(model_name="all-MiniLM-L6-v2")

 
    db = FAISS.from_documents(splits, embeddings)
    os.makedirs("vectorstore", exist_ok=True)
    db.save_local(DB_FAISS_PATH)
    print("Vector database created and saved successfully.")
    return db

if __name__ == "__main__":
    create_vector_db()
