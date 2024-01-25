import UIKit
import SwiftUI
import ComposeApp

struct RootView: UIViewControllerRepresentable {

    func makeUIViewController(context: Context) -> UIViewController {
        RootViewControllerKt.rootViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        RootView()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



