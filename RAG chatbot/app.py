import streamlit as st
from rag_engine import get_rag_chain

st.set_page_config(page_title="Local RAG Chatbot", layout="centered")

st.title("🦙 Local RAG Chatbot with LangChain & Ollama")

@st.resource_cache if hasattr(st, "resource_cache") else st.cache_resource
def load_chain():
    return get_rag_chain()

with st.spinner("Initializing Vector Database and Local Model..."):
    rag_chain = load_chain()

if "messages" not in st.session_state:
    st.session_state.messages = []

for message in st.session_state.messages:
    with st.chat_message(message["role"]):
        st.markdown(message["content"])

if user_query := st.chat_input("Ask something about your documents:"):
    st.session_state.messages.append({"role": "user", "content": user_query})
    with st.chat_message("user"):
        st.markdown(user_query)

    with st.chat_message("assistant"):
        with st.spinner("Thinking..."):
            response = rag_chain.invoke({"input": user_query})
            answer = response.get("answer", "I couldn't find an answer.")
            st.markdown(answer)
            st.session_state.messages.append({"role": "assistant", "content": answer})
