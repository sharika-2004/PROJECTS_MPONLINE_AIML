import os
from langchain_community.document_loaders import TextLoader
from langchain_text_splitters import RecursiveCharacterTextSplitter

def load_and_split_documents():
    
    if os.path.exists("data/sample.txt"):
        loader = TextLoader("data/sample.txt", encoding="utf-8")
        docs = loader.load()
    else:
        raise FileNotFoundError("Sample document not found.")

 
    text_splitter = RecursiveCharacterTextSplitter(chunk_size=500, chunk_overlap=50)
    splits = text_splitter.split_documents(docs)

    print(f"Loaded {len(docs)} document(s) and split into {len(splits)} chunks.")
    return splits

if __name__ == "__main__":
    load_and_split_documents()
